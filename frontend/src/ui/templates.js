import {row, col, css} from "../utils.js";

function title(block) {
    console.log(block.options)
    const tag = block.options.tag ?? 'h1';
    const styles = block.options.styles ?? '';
    return row(col(`<${tag}>${block.value}</${tag}>`), css(styles));
}

function text(block) {
    const tag = block.options.tag ?? 'p';
    const styles = block.options.styles ?? '';
    return row(col(`<${tag}>${block.value}</${tag}>`), css(styles));
}

function columns(block) {
    const html = block.value.map(item => col(item))
    const styles = block.options.styles ?? '';
    return row( html.join(''), css(styles))
}

function image(block) {
    return row(`<img src="${block.value}" />`)
}
export const templates = { title, text, columns, image };