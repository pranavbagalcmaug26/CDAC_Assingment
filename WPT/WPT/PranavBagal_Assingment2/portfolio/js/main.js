// Show a welcome message using a template literal.
function welcomeVisitor() {
  const name = document.getElementById("visitorName").value.trim();
  document.getElementById("welcomeMessage").innerHTML = name ? `Welcome, ${name}!` : "Please enter your name to get a welcome message.";
}

// Switch between light and dark page colours.
let darkMode = false;
function toggleTheme() {
  darkMode = !darkMode;
  document.body.style.backgroundColor = darkMode ? "#111827" : "#f4f7ff";
  document.body.style.color = darkMode ? "#f9fafb" : "#1e293b";
  document.querySelectorAll(".card").forEach(card => {
    card.style.backgroundColor = darkMode ? "#1f2937" : "white";
    card.style.color = darkMode ? "#f9fafb" : "#1e293b";
  });
  document.getElementById("themeButton").innerHTML = darkMode ? "Light mode" : "Dark mode";
}

// Hide or show the skills list.
function toggleSkills() {
  const skills = document.getElementById("skills-list");
  const button = event.target;
  if (skills.style.display === "none") {
    skills.style.display = "block";
    button.innerHTML = "Hide";
  } else {
    skills.style.display = "none";
    button.innerHTML = "Show";
  }
}

// Load public repositories from GitHub and show a friendly error if the request fails.
async function loadRepositories() {
  const list = document.getElementById("repoList");
  const status = document.getElementById("repoStatus");
  list.innerHTML = "";
  status.style.color = "inherit";
  status.innerHTML = "Loading repositories...";
  try {
    const response = await fetch("https://api.github.com/users/pranavbagalcmaug26/repos");
    if (!response.ok) throw new Error(`Request failed: ${response.status}`);
    const repos = await response.json();
    repos.forEach(repo => {
      const li = document.createElement("li");
      const link = document.createElement("a");
      link.href = repo.html_url; link.target = "_blank"; link.rel = "noopener";
      link.textContent = repo.name; li.appendChild(link); list.appendChild(li);
    });
    status.innerHTML = `Loaded ${repos.length} repositories.`;
    if (!repos.length) status.innerHTML = "No public repositories were returned.";
  } catch (error) {
    status.style.color = "red";
    status.innerHTML = `Could not load repositories: ${error.message}`;
  }
}

// Example of handling a promise with then() and catch().
Promise.resolve("Portfolio scripts loaded").then(message => console.log(message)).catch(error => console.error(error));
