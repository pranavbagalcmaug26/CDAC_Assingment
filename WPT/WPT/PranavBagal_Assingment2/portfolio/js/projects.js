// Base project class with a short summary method.
class Project {
  constructor(id, title, tech, description, link, demoLink = undefined) {
    this.id = id; this.title = title; this.tech = tech; this.description = description; this.link = link; this.demoLink = demoLink;
  }
  getSummary() { return `${this.title}: ${this.description}`; }
}
class FeaturedProject extends Project {
  constructor(id, title, tech, description, link, badge, demoLink = undefined) {
    super(id, title, tech, description, link, demoLink);
    this.badge = badge;
  }
}
const projects = [
  new FeaturedProject(1, "SindhuAai Foundation", ["Java", "Spring Boot", "React", "MySQL"], "NGO platform for donations, volunteers and resource requests.", "#", "Featured", "#"),
  new FeaturedProject(2, "Cybercrime Trap System", ["Python", "Cybersecurity"], "Honeypot logging and analysis for suspicious activity.", "#", "Featured"),
  new Project(3, "Smart Home Automation", ["IoT", "Arduino"], "Control home devices using a microcontroller and app.", "#", "#"),
  new Project(4, "Personal Portfolio", ["HTML", "CSS", "JavaScript"], "Interactive portfolio with project search and form validation.", "index.html"),
  new Project(5, "AI Chatbot", ["Python", "AI"], "A basic chatbot prototype for answering common questions.", "#")
];

// Pretend server: resolve project data after 1.5 seconds, or reject if empty.
function loadProjects() {
  return new Promise((resolve, reject) => setTimeout(() => projects.length ? resolve(projects) : reject(new Error("No projects available.")), 1500));
}
let loadedProjects = [];
async function initProjects() {
  const count = document.getElementById("projectCount");
  count.textContent = "Loading projects...";
  try {
    loadedProjects = await loadProjects();
    populateTechnologyOptions();
    renderProjects();
  } catch (error) {
    count.textContent = error.message;
  }
}
function populateTechnologyOptions() {
  const select = document.getElementById("techFilter");
  const technologies = [...new Set(loadedProjects.flatMap(project => project.tech))].sort();
  technologies.forEach(tech => {
    const option = document.createElement("option");
    option.value = tech; option.textContent = tech; select.appendChild(option);
  });
}
function renderProjects() {
  const search = document.getElementById("searchProjects").value.toLowerCase();
  const tech = document.getElementById("techFilter").value;
  const filtered = loadedProjects.filter(project => project.title.toLowerCase().includes(search) && (!tech || project.tech.includes(tech)));
  const tbody = document.getElementById("projectTable");
  tbody.innerHTML = "";
  filtered.forEach(project => {
    const row = document.createElement("tr");
    const { id, title, tech: technologies, description, link, demoLink } = project;
    [id, title, technologies.join(", "), description, link, project.demoLink ?? "Not available"].forEach((value, index) => {
      const cell = document.createElement("td");
      if (index === 4 && value !== "#") {
        const a = document.createElement("a"); a.href = value; a.textContent = "Open"; cell.appendChild(a);
      } else if (index === 5 && demoLink) {
        const a = document.createElement("a"); a.href = demoLink; a.textContent = "Demo"; cell.appendChild(a);
      } else cell.textContent = value;
      row.appendChild(cell);
    });
    tbody.appendChild(row);
  });
  document.getElementById("projectCount").textContent = `Showing ${filtered.length} of ${loadedProjects.length} projects`;
  // map builds titles; reduce counts total technology entries across all projects.
  const titles = loadedProjects.map(project => project.title);
  const totalTechnologies = loadedProjects.reduce((sum, project) => sum + project.tech.length, 0);
  document.getElementById("techCount").textContent = `Technologies used across project entries: ${totalTechnologies}. Projects: ${titles.join(" · ")}`;
  const featured = loadedProjects.filter(project => project.badge).slice(0, 2);
  const cards = document.getElementById("featuredCards"); cards.innerHTML = "";
  featured.forEach(project => {
    const card = document.createElement("article"); card.className = "card";
    const badge = document.createElement("span"); badge.className = "badge"; badge.textContent = project.badge;
    const heading = document.createElement("h3"); heading.textContent = project.title;
    const para = document.createElement("p"); para.textContent = project.getSummary();
    card.append(badge, heading, para); cards.appendChild(card);
  });
}
initProjects();
