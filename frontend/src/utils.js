export function row(content, styles = ''){
    return `<div class="row" style="${styles}">${content}</div>`
}
export function col(content){
    return `<div class="col-sm">${content}</div>`
}

export function css(styles = {}){
const toString = key => `${key}: ${styles[key]}`
return Object.keys(styles).map(toString).join( ';')
}

export const contact_icon = (key) => {
    const map = {
        mail: 'https://img.icons8.com/?size=100&id=89362&format=png&color=000000',
        phone: 'https://img.icons8.com/?size=100&id=89265&format=png&color=000000',
        language: 'https://img.icons8.com/?size=100&id=113196&format=png&color=000000'
    };
    return `<img src="${map[key]|| ''}" alt="${key}" />`
};
export const contact_text = (txt) => {
    if (txt.includes('@'))  return `<a href="mailto:${txt}">${txt}</a>`;
    if (/^\+?\d+$/.test(txt.replace(/\s/g, ''))) return `<a href="tel:${txt.replace(/\s/g, '')}">${txt}</a>`;
    if (txt === 'hudoshin') return `<a href="skype:${txt}?call">${txt}</a>`;
    return txt; // любой другой текст
};
