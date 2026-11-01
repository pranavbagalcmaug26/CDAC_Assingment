// Validate the required onboarding fields and show each error next to the field.
function validateOnboarding() {
  const name = document.getElementById("fullName").value.trim();
  const email = document.getElementById("officialEmail").value.trim();
  const qualification = document.getElementById("qualification").value;
  const department = document.getElementById("department").value;
  document.getElementById("fullNameError").textContent = name ? "" : "Full name is required.";
  document.getElementById("officialEmailError").textContent = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email) ? "" : "Enter a valid official email.";
  document.getElementById("qualificationError").textContent = qualification ? "" : "Choose a qualification.";
  document.getElementById("departmentError").textContent = department ? "" : "Choose a department.";
  return Boolean(name && /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email) && qualification && department);
}
function waitStep(message, milliseconds) {
  return new Promise((resolve, reject) => {
    const name = document.getElementById("fullName").value.trim();
    if (name.length < 3) { reject(new Error("Name must contain at least 3 characters.")); return; }
    document.getElementById("onboardingStatus").textContent = message;
    setTimeout(() => resolve(message), milliseconds);
  });
}
// Chain the onboarding steps in sequence. This is a front-end simulation only.
function startOnboarding() {
  if (!validateOnboarding()) return false;
  const name = document.getElementById("fullName").value.trim();
  waitStep("Creating your account...", 1000)
    .then(() => waitStep("Sending welcome email...", 2000))
    .then(() => waitStep("Assigning your laptop...", 1500))
    .then(() => { document.getElementById("onboardingStatus").textContent = `Welcome aboard, ${name}!`; })
    .catch(error => { document.getElementById("onboardingStatus").textContent = error.message; document.getElementById("onboardingStatus").style.color = "red"; });
  return false;
}
