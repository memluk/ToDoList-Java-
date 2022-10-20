import java.util.Scanner;
import java.util.List;

/**
 * Implement the interaction between user and the UI
 *  TODO 5: create and implement UIControl class
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
    private final List<Note> noteList;
    private final UIInputInteraction inputInteraction;
    //endregion

    //region Constructor
    public UIController() {
        noteList = TestData.getTestNotes();
        inputInteraction = new UIInputInteraction();
    }
    //endregion

    //region Methods
    public void startUI() {
        printAppName();
        interactWithUser();
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
     * TODO 7: Implement a method interact with the user
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

     /**
     * Print all the notes to the console
     * TODO 8: Set the outputs fit with the list
     */
    private void show() {
        System.out.println();
        for (int i = 0; i < noteList.size(); i++) {
            System.out.println(i + " - " + noteList.get(i));
        }
    }

    /**
     * Add a new note to the list
     * TODO 9: Create and implement a method to add new notes to the list
     */
    private void create() {
        Note note = inputInteraction.getNoteFromUser();
        noteList.add(note);
    }

    /**
     * Let user to choose a note to edit than read the new input and change the content
     * TODO 10: Create a method to edit an existing note
     */
    private void edit() {
        System.out.println(MSG_CHOOSE_INDEX_EDIT);
        show();

        Scanner scanInt = new Scanner(System.in);
        int indexToUpdate = scanInt.nextInt();

        if (indexToUpdate < noteList.size()) {
            Note note = inputInteraction.getNoteFromUser();
            noteList.set(indexToUpdate, note);
        }
    }

    /**
     * Get an input from user to delete an existing note
     * TODO 11: Create a method to delete an existing note
     */
    private void delete() {
        System.out.println(AppTexts.MSG_CHOOSE_INDEX_DELETE);
        show();

        Scanner scanInt = new Scanner(System.in);
        int indexToDelete = scanInt.nextInt();

        if (indexToDelete < noteList.size()) {
            noteList.remove(indexToDelete);
            System.out.println(AppTexts.MSG_DELETE_SUCCESSFUL);
        } else {
            System.out.println(AppTexts.MSG_INVALID_CHOICE);
        }
    }
    //endregion
}
