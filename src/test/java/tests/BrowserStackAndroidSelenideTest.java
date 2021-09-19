package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class BrowserStackAndroidSelenideTest extends TestBase {
    @Test
    @DisplayName("Search and count content")
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
@DisplayName("Check history condition")
void historyConditionTest() {
    step("Click 'History' icon", () -> {
        $(MobileBy.AccessibilityId("History")).click();
    });
    step("Check empty state text", () -> {
        $(MobileBy.id("org.wikipedia.alpha:id/history_empty_title")).shouldHave(text("No recently " +
                "viewed articles"));
    });

    }
}
