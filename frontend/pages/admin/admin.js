const API = 'http://localhost:8080/api/v1/events';
document.getElementById('add-event-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const form = e.target;
    const payload = {
        titel: form.titel.value,
        datum: form.datum.value,
        location: { id: parseInt(form.locationId.value) },
        eventTyp: { id: parseInt(form.eventTypId.value) },
        organisator: { id: parseInt(form.organisatorId.value) },
        isPublished: true
    };
    try {
        const res = await fetch(API, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        });
        if (!res.ok) throw new Error(res.status);
        const created = await res.json();
        document.getElementById('result-msg').innerHTML =
            `<div class="alert alert-success">Event #${created.id} saved!</div>`;
        form.reset();
    } catch (e) {
        console.error(e);
        document.getElementById('result-msg').innerHTML =
            `<div class="alert alert-danger">Error while saving</div>`;
    }
});
