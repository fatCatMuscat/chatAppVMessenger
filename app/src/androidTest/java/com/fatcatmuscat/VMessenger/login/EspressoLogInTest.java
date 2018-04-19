package com.fatcatmuscat.VMessenger.login;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.fatcatmuscat.VMessenger.BaseTest;
import com.fatcatmuscat.VMessenger.LoginActivity;
import com.fatcatmuscat.VMessenger.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoLogInTest extends BaseTest {

    @Rule
    public final
    ActivityTestRule<LoginActivity> mLoginActivityActivityTestRule =
            new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private Resources resources;

    @Before
    public void setup() {
        resources = InstrumentationRegistry.getTargetContext().getResources();
    }

    @Test
    public void testLogInProgressToastMessage() {
        onView(ViewMatchers.withId(R.id.login_email)).perform(typeText("avc@morse.ru"));
        closeSoftKeyboard();
        onView(withId(R.id.login_password)).perform(typeText("1234567"));
        closeSoftKeyboard();
        onView(withId(R.id.login_sign_in_button)).perform(click());
        onView(withText(R.string.toast_login_progress))
                .inRoot(withDecorView(not(mLoginActivityActivityTestRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testLoginAttemptFailedErrorMessage() {
        onView(withId(R.id.login_email)).perform(typeText("avc@morse.ru"));
        closeSoftKeyboard();
        onView(withId(R.id.login_password)).perform(typeText("123456"));
        closeSoftKeyboard();
        onView(withId(R.id.login_sign_in_button)).perform(click());

    }

    @Test
    public void loginPositiveTest() {

        onView(withId(R.id.login_email)).perform(typeText(properties.getProperty("email")));
        closeSoftKeyboard();
        onView(withId(R.id.login_password)).perform(typeText(properties.getProperty("password")));
        closeSoftKeyboard();
        onView(withId(R.id.login_sign_in_button)).perform(click());
        onView(withId(R.id.sendButton)).check(matches(isDisplayed()));


    }

}
