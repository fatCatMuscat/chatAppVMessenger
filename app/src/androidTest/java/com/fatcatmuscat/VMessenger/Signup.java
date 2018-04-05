package com.fatcatmuscat.VMessenger;

import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

// Registration page tests

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Signup {


    @Rule
    public final
    ActivityTestRule<RegisterActivity> mActivityActivityTestRule =
            new ActivityTestRule<>(RegisterActivity.class);

    private Resources resources;

    @Before
    public void setup() {
        resources = InstrumentationRegistry.getTargetContext().getResources();
    }


    @Test
    public void verifyEmailFieldRequired(){
        onView(withId(R.id.register_sign_up_button))
                .perform(click());
        onView(withId(R.id.register_email))
                .check(matches(hasErrorText(resources.getString(R.string.error_field_required))));

    }

    @Test
    public void verifyPasswordFieldRequiredErrorMessage() {


        onView(withId(R.id.register_username))
                .perform(typeText("BobTheGoose"));
        onView(withId(R.id.register_email))
                .perform(typeText("bob@thegoose.quack"));
        onView(withId(R.id.register_sign_up_button))
                .perform(click());
        onView(withId(R.id.register_password))
                .check(matches(hasErrorText(resources.getString(R.string.error_invalid_password))));

    }

    @Test
    public void verifyEmailFieldRequiredErrorMessage() {


        onView(withId(R.id.register_username)).perform(typeText("MeowCatzer"));
        onView(withId(R.id.register_password)).perform(typeText("1234567"));
        onView(withId(R.id.register_confirm_password)).perform(typeText("1234567"));
        onView(withId(R.id.register_sign_up_button)).perform(click());
        onView(withId(R.id.register_email))
                .check(matches(hasErrorText(resources.getString(R.string.error_field_required))));

    }

    @Test
    public void verifyInvalidConfirmPasswordInputErrorMessage() {
        onView(withId(R.id.register_username))
                .perform(typeText("BobTheMouse"));
        onView(withId(R.id.register_email))
                .perform(typeText("mouse@cheesse.yum"));
        onView(withId(R.id.register_password))
                .perform(typeText("1234567"));
        onView(withId(R.id.register_confirm_password))
                .perform(typeText("qwe"));
        onView(withId(R.id.register_sign_up_button))
                .perform(click());
        onView(withId(R.id.register_password))
                .check(matches(hasErrorText(resources.getString(R.string.error_invalid_password))));
    }

}
