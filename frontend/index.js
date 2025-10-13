import {templates} from './src/ui/templates.js';
import {model} from './src/models/model.js';

const {title, text, columns, image} = templates


const $site = document.querySelector('#site')

console.log(templates['title'])
model.forEach(block => {
    const toHTML = templates[block.type]
    $site.insertAdjacentHTML('beforeend', toHTML(block))
})
