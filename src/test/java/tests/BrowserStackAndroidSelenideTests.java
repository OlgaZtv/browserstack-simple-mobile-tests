package tests;


import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Owner("zatulivetrova")
@Story("Android tests")
@Feature("Android: Selenide tests")
@Tag("selenide_android")
@Tag("selenide_android")
public class BrowserStackAndroidSelenideTests extends TestBase {


    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }


    @Test
    @DisplayName("Open Wikipedia from Google in Android app")
    void openWikipediaFromGoogleTest() {
        step("Open app menu", () ->
                $(MobileBy.className("android.widget.LinearLayout")).click()
        );

        step("Type Wikipedia and search", () ->
                $(MobileBy.className("android.widget.EditText")).sendKeys(("Wikipedia"))

        );

        step("Verify content found", () ->
            $$(MobileBy.className(("android.view.View"))).shouldHave(sizeGreaterThan(0))
        );
    }
}