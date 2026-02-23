# Font Awesome Icons for JavaFX

## Common Font Awesome Icon Names (FontAwesomeIcon enum values)

Since Scene Builder doesn't have a visual search feature for Font Awesome icons, use these glyph names in your FXML:

### UI & Navigation
- `HOME` - Home icon
- `BARS` - Hamburger menu
- `ARROW_LEFT` - Left arrow
- `ARROW_RIGHT` - Right arrow
- `ARROW_UP` - Up arrow
- `ARROW_DOWN` - Down arrow
- `SEARCH` - Search/magnifying glass
- `TIMES` - Close/X icon
- `PLUS` - Plus icon
- `MINUS` - Minus icon
- `COGS` - Settings
- `GEAR` - Alternative settings

### User & Account
- `USER` - User profile
- `USERS` - Multiple users
- `USER_PLUS` - Add user
- `USER_TIMES` - Remove user
- `LOCK` - Lock icon
- `UNLOCK` - Unlock icon
- `KEY` - Key icon
- `SIGN_IN` - Sign in
- `SIGN_OUT` - Sign out

### Communication
- `ENVELOPE` - Email/mail
- `ENVELOPE_OPEN` - Open envelope
- `PHONE` - Phone
- `PHONE_SQUARE` - Phone square
- `COMMENT` - Comment
- `COMMENTS` - Multiple comments
- `BELL` - Notification bell
- `BELL_ALT` - Alternative bell

### Status & Feedback
- `CHECK` - Checkmark
- `CHECK_CIRCLE` - Checked circle
- `TIMES_CIRCLE` - Error circle
- `EXCLAMATION_TRIANGLE` - Warning
- `INFO_CIRCLE` - Information
- `QUESTION_CIRCLE` - Help/question
- `STAR` - Star (filled)
- `STAR_HALF` - Half star
- `STAR_ALT` - Alternative star

### Files & Documents
- `FILE` - File icon
- `FILE_TEXT` - Text file
- `FOLDER` - Folder
- `FOLDER_OPEN` - Open folder
- `SAVE` - Save icon
- `DOWNLOAD` - Download
- `UPLOAD` - Upload
- `PRINT` - Print
- `TRASH` - Delete/trash

### Business & Work
- `BRIEFCASE` - Briefcase
- `BUILDING` - Building
- `CALENDAR` - Calendar
- `CLOCK` - Clock
- `CLOCK_ALT` - Alternative clock
- `TASKS` - Tasks/checklist
- `LIST` - List
- `TABLE` - Table

### Social & Web
- `HEART` - Heart
- `HEART_ALT` - Alternative heart
- `THUMBS_UP` - Thumbs up
- `THUMBS_DOWN` - Thumbs down
- `SHARE` - Share
- `SHARE_ALT` - Alternative share
- `LINK` - Link

## How to Use in FXML

### Simple Icon on Button:
```xml
<?import de.jensd.iot.facade.fontawesomefx.*?>

<Button text="Delete">
    <graphic>
        <FontAwesomeIconView glyphName="TRASH" size="24" />
    </graphic>
</Button>
```

### Icon Only (No Text):
```xml
<Button>
    <graphic>
        <FontAwesomeIconView glyphName="STAR" size="20" />
    </graphic>
</Button>
```

### Style the Icon:
```xml
<FontAwesomeIconView glyphName="USER" size="32" style="-fx-fill: #FF5733;" />
```

## How to Use in Java Code

```java
import de.jensd.iot.facade.fontawesomefx.FontAwesomeIcon;
import de.jensd.iot.facade.fontawesomefx.FontAwesomeIconView;

FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.STAR);
icon.setSize("24");
button.setGraphic(icon);
```

## Finding More Icons

For a complete list of available icons, visit:
- https://fontawesome.com/v4.7.0/icons/

Use the icon names from Font Awesome v4.7 (which is what fontawesomefx 8.9 supports) and convert them to UPPERCASE with underscores (e.g., "star-alt" becomes `STAR_ALT`).

