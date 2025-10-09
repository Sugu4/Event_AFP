import { html } from '../ui/templates.js';

export class EventView {
    constructor(root) {
        this.root = root;
        this.onSelect = null;   // колбэки
        this.onBook   = null;
        this.onBack   = null;
    }

    renderList(events) {
        this.root.innerHTML = html.eventList(events);
        this.root.querySelectorAll('.card').forEach(card =>
            card.addEventListener('click', () =>
                this.onSelect?.(Number(card.dataset.id))));
    }

    renderDetails(event) {
        this.root.innerHTML = html.eventDetail(event);
        this.root.querySelector('[data-book]')
            .addEventListener('click', () => this.onBook?.(event.id));
        this.root.querySelector('[data-back]')
            .addEventListener('click', (e) => { e.preventDefault(); this.onBack?.(); });
    }
}