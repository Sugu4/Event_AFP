import { templates } from './src/ui/templates.js';
import { model } from './src/models/model.js';

const header = document.querySelector('#header-zone');
const events = document.querySelector('#events-zone');
const tools = document.querySelector('#tools-zone');
const footer = document.querySelector('#footer-zone');
const panel = document.querySelector('#panel');

/* ➊ insert menu items */
panel.insertAdjacentHTML('beforeend', `
  <div class="p-2">
    <b>☰ Menu</b><br>
    <a href="#events">Events</a><br>
    <a href="#calendar">Calendar</a><br>
    <a href="#login">LogIn</a>
  </div>
`);

/* ➋ click-toggle menu visibility */
const tab = document.querySelector('#menu-tab');
tab.addEventListener('click', () => {
    panel.classList.toggle('open');
});

model.forEach(block => {
    const html = templates[block.type](block);

    if (block.type === 'title' || block.type === 'title_text') {
        header.insertAdjacentHTML('beforeend', html);
    } else if (block.type === 'columns' && block.value[0]?.includes?.('Rock')) {
        events.insertAdjacentHTML('beforeend', html);
    } else if (block.type === 'columns' && block.value[0]?.includes?.('Search')) {
        tools.insertAdjacentHTML('beforeend', html);
    } else {
        footer.insertAdjacentHTML('beforeend', html);
    }
});