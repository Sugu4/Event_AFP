import {html} from '../ui/templates.js';
export class EventView {
    constructor(root) {
        this.root = root;
    }

    renderList(Events) {
        this.root.innerHTML = html.eventList(events);
    }

    renderDetail(event) {
        this.root.innerHTML = html.eventDetail(events);
    }
}