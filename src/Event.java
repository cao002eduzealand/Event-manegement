import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//interface
interface Event {
    String getDetails();
    String getTitle();
    void notifyObservers();
    void changeDetails(String newDetail);

    void addObserver(User observer);

}

class ConcertEvent implements Event {
    private String title;
    private String description;
    private Date date;
    private String location;
    private List<User> observers = new ArrayList<>();

    //kontruktør til at oprette concert event
    public ConcertEvent(String title, String description, Date date, String location) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
    }


//overrider metoderne fra interfacet
    @Override
    public String getDetails() {return "Concert Event Details: \n"+title+"\n"+description+"\n"+date+"\n"+location+"\n";}

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void addObserver(User observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (User observer : observers) {
            System.out.println("Notifying " + observer.getUsername() + " about changes to " + title+" details sent to "+observer.getEmail());
        }
    }

    @Override
    public void changeDetails(String newDetails) {
        this.description = newDetails;
        notifyObservers();
    }
}


class ConferenceEvent implements Event {
    private String title;
    private String description;
    private Date date;
    private String location;
    private List<User> observers = new ArrayList<>();

    //kontruktør til at lave en conference event
    public ConferenceEvent(String title, String description, Date date, String location) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    //overrider metoderne fra interfacet
    @Override
    public String getDetails() {
        return "Conference Event Details: \n"+title+"\n"+description+"\n"+date+"\n"+location+"\n";
    }

    @Override
    public void addObserver(User observer) {
        observers.add(observer);
    }

    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public void notifyObservers() {
        for (User observer : observers) {
            System.out.println("Notifying " + observer.getUsername() + " about changes to " + title+" details sent to "+observer.getEmail());
        }
    }

    @Override
    public void changeDetails(String newDetails) {
        this.description = newDetails;
        notifyObservers();
    }
}

class WorkshopEvent implements Event {
    private String title;
    private String description;
    private Date date;
    private String location;
    private List<User> observers = new ArrayList<>();

    //kontruktør til at lave et workshop event
    public WorkshopEvent(String title, String description, Date date, String location) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    //overrider metoderne fra interfacet
    @Override
    public String getDetails() {
        return "Workshop Event Details: \n"+title+"\n"+description+"\n"+date+"\n"+location+"\n";
    }

    @Override
    public void addObserver(User observer) {
        observers.add(observer);
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public void notifyObservers() {
        for (User observer : observers) {
            System.out.println("Notifying " + observer.getUsername() + " about changes to " + title+" details sent to "+observer.getEmail());
        }
    }

    @Override
    public void changeDetails(String newDetails) {
        this.description = newDetails;
        notifyObservers();
    }

}

class EventFactory {

    // metode til at oprette et event med loop
    public static Event createEvent() {
        Scanner input = new Scanner(System.in);
        Event event = null;
        while (event == null) {

            System.out.println("Type event do you want to create: ");
            System.out.println("Concert\nConference\nWorkshop");
            String eventType = input.nextLine();

//Switchcase med scanner for bruger input
            switch (eventType.toLowerCase()) {
                case "concert":
                    System.out.println("Enter title: ");
                    String title1 = input.nextLine();

                    System.out.print("Enter concert description: ");
                    String description1 = input.nextLine();

                    System.out.print("Enter concert date (yyyy-MM-dd): ");
                    String dateString = input.nextLine();
                    Date date1 = null;
                    try {
                        date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                        break;
                    }
                    System.out.print("Enter concert location: ");
                    String location1 = input.nextLine();

                    event = new ConcertEvent(title1, description1, date1, location1);
                    break;


                case "conference":
                    System.out.println("Enter title: ");
                    String title2 = input.nextLine();

                    System.out.println("Enter event Details: ");
                    String description2 = input.nextLine();

                    System.out.print("Enter conference date (yyyy-MM-dd): ");
                    String dateString2 = input.nextLine();
                    Date date2 = null;
                    try {
                        date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString2);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                        break;
                    }

                    System.out.println("Enter conference location: ");
                    String location2 = input.nextLine();

                    event = new ConferenceEvent(title2, description2, date2, location2);
                    break;


                case "workshop":
                    System.out.println("Enter title: ");
                    String title3 = input.nextLine();

                    System.out.println("Enter workshop Details: ");
                    String description3 = input.nextLine();

                    System.out.print("Enter workshop date (yyyy-MM-dd): ");
                    String dateString3 = input.nextLine();
                    Date date3 = null;
                    try {
                        date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString3);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                        break;
                    }

                    System.out.println("Enter workshop location: ");
                    String location3 = input.nextLine();

                    event = new WorkshopEvent(title3, description3, date3, location3);
                    break;


                default:
                    System.out.println("Unknown event, try again.");
                    break;
            }
        }
        return event;


    }
}



