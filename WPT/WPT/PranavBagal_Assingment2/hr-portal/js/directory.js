let employees = [];
let nextId = 100;
// Fetch employee data from a public test API.
async function loadEmployees() {
  const status = document.getElementById("directoryStatus");
  status.textContent = "Loading employees...";
  try {
    const response = await fetch("https://jsonplaceholder.typicode.com/users");
    console.log("Employee API status:", response.status);
    if (!response.ok) throw new Error(`Request failed with status ${response.status}`);
    const data = await response.json();
    employees = data.map(employee => ({ ...employee, department: "Not assigned" }));
    nextId = Math.max(...employees.map(employee => employee.id)) + 1;
    renderEmployees(); status.textContent = "Employees loaded successfully.";
  } catch (error) {
    status.textContent = `Could not load employees: ${error.message}`;
    status.style.color = "red";
  }
}
// Search by the selected field and rebuild the table.
function renderEmployees() {
  const field = document.getElementById("searchField").value;
  const text = document.getElementById("searchText").value.trim().toLowerCase();
  const search = { [field]: text };
  const filtered = employees.filter(employee => !search[field] || String(employee[field] ?? "").toLowerCase().includes(search[field]));
  const tbody = document.getElementById("employeeRows"); tbody.innerHTML = "";
  filtered.forEach(employee => {
    const { id, name, username = "", email, phone = "", department = "Not assigned" } = employee;
    const row = document.createElement("tr");
    [id, name, username, email, phone, department].forEach(value => {
      const td = document.createElement("td"); td.textContent = value; row.appendChild(td);
    });
    const action = document.createElement("td"); action.className = "employee-actions";
    const removeButton = document.createElement("button"); removeButton.textContent = "Remove";
    removeButton.onclick = () => { employees = employees.filter(item => item.id !== id); renderEmployees(); };
    action.appendChild(removeButton); row.appendChild(action); tbody.appendChild(row);
  });
  document.getElementById("totalEmployees").textContent = `Total employees: ${employees.length}`;
}
// Add a new local employee record using shorthand properties and a spread extension.
function addEmployee() {
  const name = document.getElementById("newName").value.trim();
  const department = document.getElementById("newDepartment").value.trim();
  const employee = { name, department };
  const newRecord = { ...employee, id: nextId++, username: name.toLowerCase().replace(/\s+/g, "."), email: `${name.toLowerCase().replace(/\s+/g, ".")}@technova.example`, phone: "Not provided" };
  employees.push(newRecord); document.querySelector("form").reset(); renderEmployees();
  return false;
}
