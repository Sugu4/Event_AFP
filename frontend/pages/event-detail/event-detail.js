const API = 'http://localhost:8080/api/v1/events';

async function loadSingleEvent() {
    const params = new URLSearchParams(location.search);
    const id = params.get('id');
    if (!id) return;
    try {
        const res = await fetch(`$http://127.0.0.1:8080/api/v1/events/${id}`);
        if (!res.ok) throw new Error(res.status);
        const ev = await res.json(); // Event (entity)
        renderCard(ev);
    } catch (e) {
        console.error(e);
        alert('Event not found');
    }
}

function renderCard(ev) {
    const card = document.getElementById('detail-card');
    card.innerHTML =

        <div className="card-header">
            <h3>${ev.titel}</h3>
        </div>
    <div className="card-body">
        <p><strong>Date:</strong> ${new Date(ev.datum).toLocaleString('de-DE')}</p>
        <p><strong>Location:</strong> ${ev.location.name}</p>
        <p><strong>Type:</strong> ${ev.eventTyp.name}</p>
        <p><strong>Organizer:</strong> ${ev.organisator.name}</p>
        <p><strong>Published:</strong> ${ev.isPublished ? 'Yes' : 'No'}</p>
        <p><strong>Available tickets:</strong> ${ev.availableTickets}</p>
    </div>
    <div className="card-footer text-end">
        <a className="btn btn-primary" href="events.html">Back to list</a>
    </div>
    ;
}
loadSingleEvent();