export class EventController {
    constructor(api, view) {
        this.api = api;
        this.view = view;
        this.events = [];
    }

    async loadEvents() {
        const data = await this.api.get('/events');
        this.events = data.map(d => new Event(d));
        this.view.renderList(this.events);
    }
    async select(id){
        const event = await this.api.get(`/events/${id}`);
        this.view.renderDetails(new Event(event));
    }
    async book (id){
        await this.api.post(`/bestelungs`, {event_id: id, seats: 1});
        alert("Danke! Bestelling geplaatst!");
        this.loadEvents();
    }
}