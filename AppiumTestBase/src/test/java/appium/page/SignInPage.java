package appium.page;

import org.openqa.selenium.By;

public class SignInPage {

	public static final By FORGET_PASSWORD_BUTTON = By.id("org.wordpress.android:id/forgot_password");

	public static final By SELF_HOSTED_BUTTON = By.id("org.wordpress.android:id/nux_add_selfhosted_button");

	public static final By USERNAME_INPUT = By.id("org.wordpress.android:id/nux_username");

	public static final By PASSWORD_INPUT = By.id("org.wordpress.android:id/nux_password");

	public static final By SIGN_IN_BUTTON = By.id("org.wordpress.android:id/nux_sign_in_button");

	public static final By CANCEL_BUTTON = By.id("org.wordpress.android:id/nux_dialog_left_button");
	
	public static final By SIGN_IN_ALERT_TEXT = By.id("org.wordpress.android:id/nux_dialog_title");

}
