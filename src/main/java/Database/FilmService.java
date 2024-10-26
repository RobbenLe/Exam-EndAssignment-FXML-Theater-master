package Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class FilmService implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Ticket> tickets = new ArrayList<>();  // List to store tickets
    private transient ObservableList<Film> filmList = FXCollections.observableArrayList();  // ObservableList is transient


    public FilmService() {
        filmList.addAll(
                new Film(LocalDateTime.of(2024, 10, 4, 14, 0),
                        LocalDateTime.of(2024, 10, 4, 16, 30),
                        new Movies("Rebel Moon - Part One: The Scarviger"), 72, 72, true),
                new Film(LocalDateTime.of(2024, 10, 5, 20, 0),
                        LocalDateTime.of(2024, 10, 5, 22, 30),
                        new Movies("Rebel Moon - Part Two: The Scarviger"), 72, 72, false)
        );
    }

    public ObservableList<Film> getFilmList() {
        return filmList;
    }

    public void addFilm(Film film) {
        filmList.add(film);
    }

    public void editFilm(int index, Film updatedFilm) {
        filmList.set(index, updatedFilm);
    }

    public void removeFilm(Film film) {
        filmList.remove(film);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        for (Film film : filmList) {
            if (film.getTitle().equals(ticket.getFilmTitle()) && film.getStart().equals(ticket.getShowingTime())) {
                film.purchaseTickets(ticket.getBookedSeats());
                break;
            }
        }
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    // Serialize the FilmService to a file
    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new ArrayList<>(filmList));  // Convert ObservableList to regular List
            oos.writeObject(tickets);
        } catch (IOException e) {
            System.err.println("Error saving FilmService: " + e.getMessage());
        }
    }

    // Deserialize the FilmService from a file
    public static FilmService loadFromFile(String filename) {
        FilmService filmService = new FilmService();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Film> films = (List<Film>) ois.readObject();  // Read the List of films
            filmService.filmList.setAll(films);  // Convert to ObservableList and set it
            filmService.tickets = (List<Ticket>) ois.readObject();  // Read tickets
        } catch (FileNotFoundException e) {
            System.err.println("No saved data found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading FilmService: " + e.getMessage());
        }
        return filmService;
    }

    public void setupShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> saveToFile("filmService.dat")));
    }

}
