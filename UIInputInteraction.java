import java.util.Scanner;

/**
 * This is side-class of {@link UIController}.
 * It reads the user-inputs checks the validity.
 * Returns the valid inputs to {@link UIController}.
 * TODO 7: Implement UIInputInteraction class and
 * TODO 7.1: Implement check-validation methods (getValidTitle, getValidContent)
 */
public class UIInputInteraction {
    //region Constants
    //endregion

    //region Attributes
    //endregion

    //region Constructor
    //endregion

    //region Methods
    /**
     * Read the user-input from console and return
     * @return {@link Note} : Read note
     * TODO 7.2: Implement a method to read the input
     */
    public Note getNoteFromUser() {
        System.out.println(UIController.MSG_INPUT_NOTE_DATA);

        String title = getValidTitle();
        String content = getValidContent();

        System.out.println(UIController.MSG_INPUT_IMPORTANT);

        Scanner scanBool = new Scanner(System.in);
        boolean isImportant = scanBool.nextBoolean();

        return new Note(title, content, isImportant);
    }

    /**
     * Read the title from console and check the validity (Min. 3, Max. 20 characters).
     * @return {@link String} : Title of the note
     * TODO 7.3: Implement a method to read the input-title
     */
    private String getValidTitle() {
        String title = Note.DEF_STR_VAL;

        boolean isValid = false;

        while (!isValid) {
            System.out.println(UIController.MSG_INPUT_TITLE);
            Scanner scanStr = new Scanner(System.in);
            title = scanStr.nextLine();

            if (title.length() >= NoteSettings.MIN_LENGTH_TITLE && title.length() <= NoteSettings.MAX_LENGTH_TITLE) {
                isValid = true;
            } else {
                System.out.printf("\nInvalid Titel. The Titel must have %d to %d characters.",
                        NoteSettings.MIN_LENGTH_TITLE, NoteSettings.MAX_LENGTH_TITLE);
            }
        }
        return title;
    }

    /**
     * Read a new note from the console and check its validity.
     * @return {@link String} : Content of the note
     * TODO 7.4: Implement a method to read the input-content
     */
    private String getValidContent() {
        String content = Note.DEF_STR_VAL;
        boolean isValid = false;

        while (!isValid) {
            System.out.println(UIController.MSG_INPUT_CONTENT);
            Scanner scanStr = new Scanner(System.in);
            content = scanStr.nextLine();

            if (content.length() <= NoteSettings.MAX_LENGTH_CONTENT) {
                isValid = true;
            } else {
                System.out.printf("\nInvalid Content! The content can have until %d characters.",
                        NoteSettings.MAX_LENGTH_CONTENT);
            }
        }

        return content;
    }
    //endregion
}
