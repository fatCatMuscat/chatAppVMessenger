package com.fatcatmuscat.VMessenger;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
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

    @Test
    public void testfirstTest(){
        onView(withId(R.id.register_sign_up_button))
                .perform(click());
        onView(withId(R.id.register_email))
                .check(matches(hasErrorText("This field is required")));
    }

}
