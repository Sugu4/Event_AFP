export const html = {
    eventList: (list) => `
    <h1>Events</h1>
    <div class="events">
      ${list.map(event => `
        <div class="card" data-id="${event.id}">
          <h3>${event.name}</h3>
          <p>${new Date(event.datum).toLocaleDateString('de-DE')}</p>
        </div>`).join('')}
    </div>`,

    eventDetail: (event) => `
    <h1>${event.name}</h1>
    <p>${event.description}</p>
    <button data-book="${event.id}">Buchen</button>
    <a href="#" data-back>← Zurück</a>`
};