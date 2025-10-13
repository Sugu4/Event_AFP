import {row, col} from "../utils.js";

function title(block) {
    return row(`<h1>${block.value}</h1>`)
}

function text(block) {
    return row(`<p>${block.value}</p>`)
}

function columns(block) {
    const html = block.value.map(item => col(item))
    return row( html.join(''))
}

function image(block) {
    return row(`<img src="${block.value}" />`)
}
export const templates = { title, text, columns, image };