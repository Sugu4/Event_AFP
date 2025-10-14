import { templates } from './src/ui/templates.js';
import { model } from './src/models/model.js';

const header = document.querySelector('#header-zone');
const events = document.querySelector('#events-zone');
const tools = document.querySelector('#tools-zone');
const footer = document.querySelector('#footer-zone');
const panel = document.querySelector('#panel');

model.forEach(block => {
    const html = templates[block.type](block);

    if (block.type === 'title' || block.type === 'text') {
        header.insertAdjacentHTML('beforeend', html);
    } else if (block.type === 'columns' && block.value[0]?.includes?.('Menu')) {
        panel.insertAdjacentHTML('beforeend', html);
    } else if (block.type === 'columns' && block.value[0]?.includes?.('Rock')) {
        events.insertAdjacentHTML('beforeend', html);
    } else if (block.type === 'columns' && block.value[0]?.includes?.('Search')){
        tools.insertAdjacentHTML('beforeend', html);
    }else {
        footer.insertAdjacentHTML('beforeend', html);
    }
});