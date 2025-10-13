import {row, col, css} from "../utils.js";

function title(block) {
    console.log(block.options)
    const tag = block.options.tag ?? 'h1';
    const styles = block.options.styles ?? '';
    return row(col(`<${tag}>${block.value}</${tag}>`), css(styles));
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