import javax.swing.*;

public class OrderPicking{
public static void main(String[] args) {
double total = 0.0;

int order = JOptionPane.showConfirmDialog(null,
"Would you like to order a Beverage, Entree or Dessert?","take your Order ", JOptionPane.YES_OPTION);

if (order != JOptionPane.YES_OPTION) {
JOptionPane.showMessageDialog(null, "Thank you for visiting. Goodbye!");

System.exit(0); // Terminate the program
}

// Order Beverage
int wantBeverage = JOptionPane.showConfirmDialog(null, "Do you want to order a beverage?", "Order Beverage", JOptionPane.YES_NO_OPTION);

if (wantBeverage == JOptionPane.YES_OPTION) {
total += orderCategory("Beverage", new String[]{"Iced Coffee ($4.00)", "Water ($1.00)", "Milk Shake ($4.50)", "Milk ($1.50)"," Sparkling Water ($2.00)"},
new double[]{4.00, 1.00, 4.50, 1.50,2.00});
}

// Order Entree

int wantEntree =

JOptionPane.showConfirmDialog(null, "Do you want to order" +
" an entree?", "Order Entree", JOptionPane.YES_NO_OPTION);

if (wantEntree == JOptionPane.YES_OPTION) {
total += orderCategory("Entree", new String[]{"Chicken Nuggets ($5.00)", "Rice Cakes ($2.50)",
"Chicken Wrap ($6.00)", "Chicken Strips ($5.50)"}, new double[]{5.00, 2.50, 6.00,5.50});
}

// Order Dessert
int wantDessert =
JOptionPane.showConfirmDialog(null, "Do you want to order a dessert?", "Order Dessert", JOptionPane.YES_NO_OPTION);
if (wantDessert == JOptionPane.YES_OPTION) {
total += orderCategory("Dessert", new
String[]{"Chocolate Chip Cookies ($2.50)", "Banana Cookies ($3.00)", "Yoghurt ($1.50)"},

new double[]{2.50, 3.00, 1.50});

}

// Triggering deleteOption method and updating total

double deletedPrice = deleteOption(new

String[]{"Iced Coffee ($4.00)", "Water ($1.00)", "Milk Shake ($4.50)", "Milk ($1.50)", "Sparkling Water ($2.00)", 
"Chicken Nuggets ($5.00)", "Rice Cakes($2.50)", "Chicken Wrap ($6.00)", "Chicken Strips($5.50)", 
"Chocolate Chip Cookies ($2.50)", "Banana Cookies ($3.00)", "Yoghurt ($1.50)"});

total -= deletedPrice;

JOptionPane.showMessageDialog(null, "Your total price is: $" + total);
}

public static double orderCategory(String category,
String[] items, double[] prices) {

double total = 0.0;

while (true) {
int option =

JOptionPane.showOptionDialog(null, "Please place your order for " + category + ":", "Order Menu",
JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, items, "No");

if (option == -1 || option == items.length +1) {

// User clicked on close button or No option

break;
}

int quantity;
while (true) {
String quantityString =

JOptionPane.showInputDialog("Enter quantity for " + items[option] + ":");

if (quantityString == null ||

quantityString.equals("")) {

int cancelOrder =

JOptionPane.showConfirmDialog(null, "Do you want to go back to the menu options for " + category + "?"
, "Cancel Order", JOptionPane.YES_NO_OPTION);
if (cancelOrder ==
JOptionPane.YES_OPTION) {

return total;
}
} else {
try {
quantity =
Integer.parseInt(quantityString);

if (quantity <= 0) {
int cancelOrder = JOptionPane.showConfirmDialog(null, "Do you want to go back to the menu options for " + category + "?", 
"Cancel Order", JOptionPane.YES_NO_OPTION);

if (cancelOrder == JOptionPane.YES_OPTION) {

return total;
}
} else {
break;
}
} catch (NumberFormatException e) {

JOptionPane.showMessageDialog(null, "Please enter a valid quantity.");

}
}
}

double itemTotal = prices[option] * quantity;
total += itemTotal;

JOptionPane.showMessageDialog(null, "Added "
+ quantity + " " + items[option] + "(s) to your order. Subtotal for this item: $" + itemTotal);

int choice = JOptionPane.showConfirmDialog(null, "Do you want to order more from " + category + "?", "Continue Ordering",JOptionPane.YES_NO_OPTION);

if (choice == JOptionPane.NO_OPTION) {
break;
}
}

return total;
}

public static double deleteOption(String[] items) {
String itemToDelete = (String)

JOptionPane.showInputDialog(null, "Select the item you want to delete:", "Delete Item", JOptionPane.QUESTION_MESSAGE, null, items, items[0]);

if (itemToDelete != null) {
String priceString =

itemToDelete.substring(itemToDelete.indexOf("$") + 1, itemToDelete.indexOf(")"));

double deletedPrice = Double.parseDouble(priceString);

JOptionPane.showMessageDialog(null, "Deleted" + itemToDelete + " from your order.");

return deletedPrice;
}

return 0.0;
}
}