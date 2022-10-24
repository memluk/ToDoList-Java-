import java.util.Scanner;

import static AppTexts.*;
import static Note.DEF_STR_VAL;

/**
 * This is side-class of {@link UIController}.
 * It reads the user-inputs checks the validity.
 * Returns the valid inputs to {@link UIController}.
 */
public class UIInputInteraction {
    //region Methods
    /**
     * Read the user-input from console and return
     * @return {@link Note} : Read note
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
                System.err.printf(MSG_INVALID_TITLE, NoteSettings.MIN_LENGTH_TITLE, NoteSettings.MAX_LENGTH_TITLE);
            }
        }
        return title;
    }

    /**
     * Read a new note from the console and check its validity.
     * @return {@link String} : Content of the note
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
                System.err.printf(MSG_INVALID_CONTENT, NoteSettings.MAX_LENGTH_CONTENT);
            }
        }
        return content;
    }
    
        /**
     * Ask whether the Note is important and check the validity (Y/y or N/n)
     * @return {@link String} : y/n or Y/N
     */
    private boolean getValidImportance() {
        String importance = DEF_STR_VAL;
        boolean isValid = false;
        boolean returnValue = false;

        while (!isValid) {
            System.out.printf(AppTexts.MSG_INPUT_IMPORTANT);
            Scanner scanStr = new Scanner(System.in);
            importance = scanStr.nextLine();

            if (importance.equals("y") || importance.equals("Y")) {
                isValid = true;
                returnValue = true;
            } else if (importance.equals("n") || importance.equals("N")) {
                isValid = true;
                returnValue = false;
            } else {
                System.err.printf(MSG_INVALID_IMPORTANCE);
            }
        }
        return returnValue;
    }
    //endregion
}
