// Menu data is stored as objects and used to create the dropdown options.
const menu = [
  { id: 1, name: "Classic Cappuccino", price: 140 },
  { id: 2, name: "Code & Cocoa Combo", price: 220 },
  { id: 3, name: "Cold Brew", price: 170 },
  { id: 4, name: "Butter Croissant", price: 110 },
  { id: 5, name: "Chocolate Brownie", price: 90 }
];
const cart = [];
const menuSelect = document.getElementById("menuItem");
menu.forEach(item => {
  const option = document.createElement("option");
  option.setAttribute("value", item.id);
  option.textContent = `${item.name} — ₹${item.price}`;
  menuSelect.appendChild(option);
});
// Add a valid quantity of the selected menu item to the cart.
function addToOrder() {
  const item = menu.find(product => product.id === Number(menuSelect.value));
  const quantity = parseInt(document.getElementById("quantity").value, 10);
  const error = document.getElementById("orderError");
  if (!Number.isInteger(quantity) || quantity <= 0) { error.textContent = "Quantity must be a positive whole number."; return; }
  error.textContent = "";
  cart.push({ ...item, quantity });
  renderOrder();
}
// Rebuild the order list; each row has a Remove button.
function renderOrder() {
  const list = document.getElementById("orderList"); list.innerHTML = "";
  cart.forEach((item, index) => {
    const li = document.createElement("li");
    li.textContent = `${item.name} × ${item.quantity} — ₹${item.price * item.quantity} `;
    const button = document.createElement("button"); button.textContent = "Remove";
    button.onclick = () => { cart.splice(index, 1); renderOrder(); };
    li.appendChild(button); list.appendChild(li);
  });
  renderBill();
}
// Use a switch to determine the delivery charge for the selected area.
function getDeliveryCharge() {
  let charge;
  switch (document.getElementById("deliveryArea").value) {
    case "local": charge = 30; break;
    case "nearby": charge = 50; break;
    case "far": charge = 80; break;
    default: charge = 0;
  }
  return charge;
}
// Callback example: apply a supplied pricing rule to an amount.
function applyRule(amount, rule) { return rule(amount); }
console.log("Anonymous callback example:", applyRule(200, function(amount) { return amount * 0.05; }));
console.log("Arrow callback example:", applyRule(200, amount => amount * 0.10));
// Calculate subtotal, discount, delivery and total using reduce.
function renderBill() {
  const subtotal = cart.reduce((sum, item) => sum + item.price * item.quantity, 0);
  let discountRate;
  if (subtotal >= 1000) discountRate = 0.15;
  else if (subtotal >= 600) discountRate = 0.10;
  else if (subtotal >= 300) discountRate = 0.05;
  else discountRate = 0;
  const discount = subtotal * discountRate;
  const delivery = cart.length ? getDeliveryCharge() : 0;
  const totalItems = cart.reduce((sum, item) => sum + item.quantity, 0);
  const itemText = totalItems === 1 ? "1 item" : `${totalItems} items`;
  document.getElementById("bill").textContent = `Bill (${itemText}): Subtotal ₹${subtotal.toFixed(2)} | Discount ₹${discount.toFixed(2)} (${discountRate * 100}%) | Delivery ₹${delivery.toFixed(2)} | Final total ₹${(subtotal - discount + delivery).toFixed(2)}`;
}
// Promise resolves after two seconds, but rejects if the cart is empty.
function submitOrder() {
  return new Promise((resolve, reject) => {
    if (!cart.length) { reject(new Error("Your cart is empty. Add an item first.")); return; }
    setTimeout(() => resolve(`BB-${Math.floor(100000 + Math.random() * 900000)}`), 2000);
  });
}
async function placeOrder() {
  const status = document.getElementById("orderStatus");
  status.textContent = "Placing your order...";
  try {
    const orderNumber = await submitOrder();
    status.textContent = `Order placed successfully! Order number: ${orderNumber}`;
  } catch (error) {
    status.textContent = error.message;
  }
}
// Display a limited-time banner three seconds after page load.
setTimeout(() => {
  const banner = document.getElementById("offerBanner");
  banner.hidden = false;
  banner.textContent = "Special offer: Get 5% off orders of ₹300 or more!";
}, 3000);
renderBill();
