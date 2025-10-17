const API = 'http://localhost:8080/api/v1/events'; // adjust if your backend runs on different port

async function loadEvents() {
    try {
        const res = await fetch("http://127.0.0.1:8080/api/v1/events");
        if (!res.ok) throw new Error(res.status);
        const data = await res.json(); // List<EventDTO>
        renderTable(data); // Call renderTable with the fetched data
    } catch (error) {
        console.error('Error loading events:', error);
    }
}

function renderTable(events) {
    const tbody = document.getElementById('events-tbody');
    tbody.innerHTML = '';
    events.forEach(ev => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${ev.id}</td>
            <td>${ev.titel}</td>
            <td>${new Date(ev.datum).toLocaleDateString('de-DE')}</td>
            <td>${ev.locationName}</td>
            <td>${ev.eventTypName}</td>
            <td>${ev.organisatorName}</td>
            <td>
                <a class="btn btn-sm btn-outline-primary" href="../event-detail/event-detail.html?id=${ev.id}">Details</a>
            </td>
        `;
        tbody.appendChild(tr);
    });
}

// Call loadEvents when the page loads
document.addEventListener('DOMContentLoaded', loadEvents);