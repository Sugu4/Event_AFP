export class Event {
    constructor(id, name, description, datum) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.datum = datum;
    }
    get formattedDate() {
        return new Date(this.datum).toLocaleDateString('de-DE');
    }
}