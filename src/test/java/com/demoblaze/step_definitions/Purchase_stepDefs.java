package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Purchase_stepDefs {
    HomePage homePage=new HomePage();
    CartPage cartPage=new CartPage();
    int expectedPurchaseAmount=0;
    @When("The user adds {string} product from {string} category")
    public void the_user_adds_product_from_category(String product, String category) {
        expectedPurchaseAmount+=homePage.addProduct(product, category);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }
    @When("The user removes {string} chosen product from Cart page")
    public void the_user_removes_chosen_product_from_cart_page(String removeProduct) {
        expectedPurchaseAmount-= cartPage.removeProduct(removeProduct);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }
    @When("The user places order and capture and log amount")
    public void the_user_places_order_and_capture_and_log_amount() {
        cartPage.finishPurchase_logAmount();
    }
    @Then("The user verifies purchase amount")
    public void the_user_verifies_purchase_amount() {
        cartPage.verifyPurchaseAmount(expectedPurchaseAmount);
    }
    @When("The user adds following products  from related category to the cart and return Home page")
    public void the_user_adds_following_products_from_related_category_to_the_cart_and_return_home_page(List<Map<String,String>> dataTable) {
        System.out.println("dataTable.size() = " + dataTable.size());
        for (int i = 0; i < dataTable.size(); i++) {
            System.out.println("i = " + i);
            System.out.println("dataTable.get(i).values() = " + dataTable.get(i).values());
            String[] dataArray=dataTable.get(i).values().toArray(new String[i]);
            if(dataArray.length>=2){
                String product=dataArray[1];
                String category=dataArray[0];
                System.out.println("product = " + product);
                System.out.println("category = " + category);
                expectedPurchaseAmount+= homePage.addProduct(product,category);
                System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
            }else {
                System.out.println("There is not enough element value");
            }

        }
    }
    @When("The user removes {string} chosen product from {string} page")
    public void the_user_removes_chosen_product_from_page(String removeProduct, String menu) {
        expectedPurchaseAmount-= cartPage.removeProduct(removeProduct, menu);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }


}