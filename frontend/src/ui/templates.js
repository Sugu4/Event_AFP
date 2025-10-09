export const html = {
  eventList: (list) => `
   <h1> Events <h1>
   <div class = "events">
   ${list.map(event => `
    <div class = "card" onclick="app.ctrl.select(${event.id})">
    <h3> ${event.name}</h3>
    <p> ${new Date (event.datum).toLocaleDateString(de-De)}</p>
       
     `)}  
    `
};
