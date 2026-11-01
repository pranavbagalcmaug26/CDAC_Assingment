// Toggle the password field between hidden and visible.
function togglePassword() {
  const password = document.getElementById("password");
  const button = event.target;
  if (password.type === "password") {
    password.setAttribute("type", "text"); button.textContent = "Hide";
  } else {
    password.setAttribute("type", "password"); button.textContent = "Show";
  }
}
// Validate the password as the user types.
function checkPassword() {
  const value = document.getElementById("password").value;
  const rule = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^A-Za-z0-9]).{8,}$/;
  document.getElementById("passwordError").textContent = rule.test(value) ? "" : "Use 8+ characters with uppercase, lowercase, number and special character.";
}
// Validate username and password on submission.
function validateLogin() {
  const username = document.getElementById("username").value.trim();
  document.getElementById("usernameError").textContent = username ? "" : "Username is required.";
  checkPassword();
  const valid = username && !document.getElementById("passwordError").textContent;
  document.getElementById("loginMessage").textContent = valid ? "Demo validation passed. No real login server is connected." : "";
  return false;
}
