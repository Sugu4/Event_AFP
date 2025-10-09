export class EventController {
    constructor(api, view) {
        this.api = api;
        this.view = view;
        this.events = [];

        // Move event handler assignments inside constructor
        this.view.onSelect = id => this.select(id);
        this.view.onBook = id => this.book(id);
        this.view.onBack = () => this.onBack();
    }

    async loadEvents() {
        const data = await this.api.get('/events.json');
        this.events = data.map(d => new Event(d));
        this.view.renderList(this.events);
    }

    async select(id) {
        const event = await this.api.get(`/events.json/${id}`);
        this.view.renderDetails(new Event(event));
    }

    async book(id) {
        try {
            await this.api.post(`/bestelungs`, {event_id: id, seats: 1});
            alert("Danke! Bestelling geplaatst!");
            await this.loadEvents();
        } catch (error) {
            console.error('Booking failed:', error);
            alert("Booking failed. Please try again.");
        }
    }

    onBack() {
        this.view.renderList(this.events);
    }
}