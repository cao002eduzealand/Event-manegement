import java.util.List;
import java.util.Arrays;
public class Main {
            public static void main(String[] args) {
                // Initialisere UserManager
                UserManager userManager = UserManager.getInstance();
                userManager.registerUser("Henning", "Henning@gmail.com");
                userManager.registerUser("Fernandez", "IhaveAids@gmail.com");
                userManager.registerUser("Putin", "russia@gmail.com");

                // Skab events ved brug af Eventfactory
                Event event = EventFactory.createEvent();
                System.out.println(event.getDetails());

                // Registrer brugere til events
                EventRegistration eventRegistration = new EventRegistration();
                eventRegistration.registerForEvent(new User("Fernandez", "IhaveAids@gmail.com"), event);
                eventRegistration.registerForEvent(new User("Henning", "Henning@gmail.com"), event);
                eventRegistration.registerForEvent(new User("Putin", "russia@gmail.com"), event);

                // skift event detajler og underret Observers
                event.changeDetails("Updated Rock Concert - New Time");

                // Generer rapport
                List<User> allUsers = userManager.getUsers();
                List<Event> allEvents = Arrays.asList(event);
                ReportGenerator reportGenerator = new ReportGenerator();
                reportGenerator.generateReport(allUsers, allEvents);
            }
        }