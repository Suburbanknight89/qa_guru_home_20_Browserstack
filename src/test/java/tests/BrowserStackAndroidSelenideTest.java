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
    @DisplayName("Search and open an article")
    void open() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("window");
        });
        step("Click an content", () ->
                $$(MobileBy.className("android.widget.TextView")).findBy(text("Search Wikipedia")).click());
        step("Check title 'Window' ", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text")).shouldHave(text("Window")));
    }
}
