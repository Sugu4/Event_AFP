import {row, col, css, contact_icon, contact_text} from "../utils.js";

function title(block) {
    const tag   = block.options.tag ?? 'h1';
    const style = block.options.styles ?? '';

    const classAttr = (typeof style === 'string' && style) ? `class="${style}"` : '';
    const styleAttr = (typeof style === 'object') ? `style="${css(style)}"` : '';

    return `<${tag} ${classAttr} ${styleAttr}>${block.value}</${tag}>`;
}

function title_text(block) {
    const tag = block.options.tag ?? 'p';
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
    return row(html.join(''), css(styles))
}

function image(block) {
    return row(`<img src="${block.value}"  alt=""/>`)
}

function contacts(block) {
    const html = block.value.map(item => {
        const icon = contact_icon(item.icon);
        const text = contact_text(item.text);
        return col(`<span class="icon">${icon}</span><span class="contacts__text">${text}</span>`);
    })
    const styles = block.options.styles ?? '';
    return row(html.join(''), css(styles))
}


export const templates = {title, text, columns, image, contacts, title_text};