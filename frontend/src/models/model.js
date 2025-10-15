export const model = [
    {
        type: 'title',
        value: 'Veranstaltung Köln',
        options: {
            tag: 'h1',
            styles: 'main-title'
        }
    },
    {
        type: 'title_text',
        value: 'Erlebe die besten Events in Köln – Konzerte, Kultur & mehr!',
        options: {
            tag: 'h4',
            styles: {
                background: 'linear-gradient(135deg, #4285f4 0%, #34a853 100%)',
                padding: '0px',
                'text-shadow': '1px 1px 2px rgba(0, 0, 0, 0.3)',
                'text-align': 'center',
                'border-radius': '8px',
                'box-shadow': '0 1px 1px rgba(0, 0, 0, 0.2)',
                'font-weight': 'bold',
                margin: '0',
                color: '#fff'
            }
                // 'title-text'
        }
    },

    {
        type: 'columns',
        value: [/* items */],
        options: {
            styles: ''
        }
    },

    /* Event-feed*/
    {
        type: 'columns',
        value: [
            // column_1
            `<div style="cursor:pointer;" onclick="alert('Rock-Konzert')">
       <img src="./assets/event_1.png" alt="Rock am Ring" style="width:100%;border-radius:6px;">
       <h4>🎸 Rock am Ring</h4>
       <p>12.12.2025<br>Köln Arena</p>
     </div>`,
            // column_2
            `<div style="cursor:pointer;" onclick="alert('Jazz-Abend')">
       <img src="assets/event_2.png" alt="Jazz-Abend" style="width:100%;border-radius:6px;">
       <h4>🎺 Jazz-Abend</h4>
       <p>15.11.2025<br>Club B</p>
     </div>`,
            // column_3
            `<div style="cursor:pointer;" onclick="alert('Weihnachtsmarkt')">
       <img src="assets/event_3.png" alt="Weihnachtsmarkt" style="width:100%;border-radius:6px;">
       <h4>🎄 Weihnachtsmarkt</h4>
       <p>20.12.2025<br>Heumarkt</p>
     </div>`
        ],
        options: {
            styles: {
                marginLeft: '220px',
                height: '33vh',
                overflowY: 'auto',
                display: 'flex',
                gap: '15px',
                padding: '15px',
                background: '#fafafa',
                borderRadius: '8px',
                boxShadow: '0 2px 4px rgba(0,0,0,0.1)'
            }
        }
    },
    //Tools feed
    {
        type: 'columns',
        value: [
            /* 1. Search */
            `<div>
         <h5>Search</h5>
         <input type="text" class="form-control form-control-sm" placeholder="Event name...">
       </div>`,
            /* 2. Category List */
            `<div>
         <h5>Category List</h5>
         <ul class="list-unstyled">
           <li><a href="#rock">Rock</a></li>
           <li><a href="#jazz">Jazz</a></li>
           <li><a href="#classic">Classic</a></li>
         </ul>
       </div>`,
            /* 3. Event List */
            `<div>
         <h5>Events List</h5>
         <ul class="list-unstyled">
           <li><a href="#getAllEvents">See all events</a></li>
         </ul>
       </div>`,
            /* 4. Events-Calendar */
            `<div>
         <h5>Events-Calendar</h5>
         <input type="month" class="form-control form-control-sm">
       </div>`,
            /* 5. LogIn / Register */
            `<div>
         <h5>LogIn / Register</h5>
         <button class="btn btn-primary btn-sm w-100">LogIn</button>
         <button class="btn btn-outline-primary btn-sm w-100 mt-2">Register</button>
       </div>`
        ],
        options: {
            styles: {height: '100%', width: "100%", gap: '10px'}
        }
    },
    // Footer
    {
        type: 'contacts',
        value: [
            {icon: 'mail', text: 'imperia_of_events@gmail.com'},
            {icon: 'phone', text: '+49 176 12345678'},
            {icon: 'language', text: 'Deutsch'},
            {
                icon: 'copyright',
                text: '© 2025 Veranstaltung Köln | <a href="#impressum">Impressum</a> | <a href="#datenschutz">Datenschutz</a>'
            }
        ],
        options: {
            styles: {
                marginLeft: '220px',
                marginTop: '20px',
                background: 'linear-gradient(135deg, rgba(66,133,244,.8) 0%, rgba(52,168,83,.8) 100%)',
                padding: '15px',
                color: '#fff',
                borderRadius: '8px',
                fontSize: '1em'
            }
        }
    }
]