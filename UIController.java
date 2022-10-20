import java.util.Scanner;

/**
 * Implement the interaction between user and the UI
 *  TODO 2 create and implement UIControl class
 *  TODO 9 implement a delete() method
 */
public class UIController {
    //region Constants
    public static final String MSG_INPUT_NOTE_DATA = "\nPlease, enter the following information: ";
    public static final String MSG_INPUT_TITLE = "Titel: ";
    public static final String MSG_INPUT_CONTENT = "Content: ";
    public static final String MSG_INPUT_IMPORTANT = "Is this note important?";
    public static final String MSG_CHOOSE_INDEX_EDIT = "\nPlease, select the note, you want to edit: ";
    //endregion

    //region Attributes
    private Note[] notes;
    //endregion

    //region Constructor
    //endregion

    //region Methods
    public void startUI() {
        initialize();
        printAppName();
        interactWithUser();
    }

    private void initialize() {
//        notes = new Note[10];
        notes = TestData.getTestNotes();
    }

    private void printAppName() {
        System.out.println("""
                ====================
                     MyToDoList 
                ====================
                """);
    }

    /**
     * Print main menu, receive the user-input and calls the related methods
     * The interaction with main menu runs through a do-while loop
     */
    private void interactWithUser() {
        boolean endApp = false;

        do {
            //Show main menu
            printMainMenu();

            //Read user input
            Scanner scanInt = new Scanner(System.in);
            int userChoice = scanInt.nextInt();

            //Evaluate the user input and initiate the related method
            switch (userChoice) {
                case AppCommands.USER_CMD_SHOW -> show();
                case AppCommands.USER_CMD_CREATE -> create();
                case AppCommands.USER_CMD_EDIT -> edit();
                case AppCommands.USER_CMD_DELETE -> delete();
                case AppCommands.USER_CMD_EXIT -> endApp = true;
                default -> System.out.println(AppTexts.MSG_INVALID_CHOICE);
            }
        } while (!endApp);
    }

    private void printMainMenu() {
        System.out.println(AppTexts.MAIN_MENU_SHOW);
        System.out.println(AppTexts.MAIN_MENU_CREATE);
        System.out.println(AppTexts.MAIN_MENU_EDIT);
        System.out.println(AppTexts.MAIN_MENU_DELETE);
        System.out.println(AppTexts.MAIN_MENU_EXIT);
        System.out.println(AppTexts.MSG_USER_CHOICE);
    }

    private void show() {
        System.out.println();
        for (int i = 0; i < notes.length; i++) {
            System.out.println(i + " - " + notes[i]);
        }
        System.out.println("\nPrint the notes");
    }

    private void create() { System.out.println("\nAdd a new note"); }

    private void edit() { System.out.println("\nEdit a note"); }

    private void delete() { System.out.println("\nDelete a note"); }
    //endregion
}
