// Validate the visitor's name while typing.
function checkName() {
  const value = document.getElementById("name").value.trim();
  document.getElementById("nameError").textContent = value ? "" : "Name is required.";
}
function checkEmail() {
  const value = document.getElementById("email").value.trim();
  document.getElementById("emailError").textContent = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value) ? "" : "Enter a valid email address.";
}
// Validate every field before accepting the form.
function validate() {
  checkName(); checkEmail();
  const phone = document.getElementById("phone").value.trim();
  const message = document.getElementById("message").value.trim();
  document.getElementById("phoneError").textContent = /^\d{10}$/.test(phone) ? "" : "Phone must contain exactly 10 digits.";
  document.getElementById("messageError").textContent = message.length >= 20 ? "" : "Message must be at least 20 characters.";
  const valid = !document.querySelector(".error-span:not(:empty)");
  if (valid) {
    document.getElementById("thankYou").textContent = `Thank you, ${document.getElementById("name").value.trim()}! Your message is ready.`;
  }
  return false; // No backend is connected; prevent an actual network submission/reload.
}
