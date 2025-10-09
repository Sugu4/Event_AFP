import {html} from '../ui/templates.js';
export class EventView {
    constructor(root) {
        this.root = root;
    }

    renderList(events) {
        this.root.innerHTML = html.eventList(events);
    }

    renderDetails(events) {
        this.root.innerHTML = html.eventDetail(events);
    }
}