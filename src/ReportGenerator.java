import java.util.List;
//klasse
public class ReportGenerator {
    //Metode til at genererer en report om brugere og events
    public void generateReport(List<User> users, List<Event> events) {
            System.out.println("Event Registration Report:");
            for (Event event : events) {
                System.out.println("Event: " + event.getTitle());

            }
        }
    }
// Klasse
class EventRegistration {
    //Metode til at registerer brugere til events
    public void registerForEvent(User user, Event event) {
        event.addObserver(user);
        System.out.println(user.getUsername() +" registered for " + event.getTitle());
    }
}





