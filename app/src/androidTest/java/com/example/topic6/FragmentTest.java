package com.example.topic6;

import android.os.SystemClock;
import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class FragmentTest {
    @Rule
    public ActivityTestRule<ViewPagerActivity> activityTestRule =
            new ActivityTestRule<>(ViewPagerActivity.class);

    @Before
    public void yourSetUPFragment() {
        activityTestRule.getActivity()
                .getFragmentManager().beginTransaction();
    }

    @Test
    public void testFragment() {
        onView(withId(R.id.etFirst)).perform(typeText("12"));
        onView(withId(R.id.etSecond)).perform(typeText("12"));
        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.tvOutput)).check(matches(withText("24")));
        //or
        //onView(withId(R.id.tvOutput)).check(matches(isDisplayed()));
    }
}


