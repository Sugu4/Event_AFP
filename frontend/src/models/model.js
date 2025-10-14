export const model = [
    {
        type: 'title',
        value: 'Veranstaltung Köln',
        options: {
            tag: 'h1',
            styles: {
                background: 'linear-gradient(135deg, #4285f4 0%, #34a853 100%)',
                padding: '20px',
                color: '#fff',
                textShadow: '1px 1px 2px rgba(0,0,0,0.3)',
                textAlign: 'center',
                borderRadius: '8px',
                boxShadow: '0 2px 4px rgba(0,0,0,0.2)',
                fontWeight: 'bold',
                margin: '0 0 10px 0'
            }
        }
    },
    {
        type: 'text',
        value: 'Erlebe die besten Events in Köln – Konzerte, Kultur & mehr!',
        options: {
            tag: 'p',
            styles: {
                background: 'linear-gradient(135deg, #4285f4 0%, #34a853 100%)',
                padding: '20px',
                textShadow: '1px 1px 2px rgba(0,0,0,0.3)',
                textAlign: 'center',
                borderRadius: '8px',
                boxShadow: '0 2px 4px rgba(0,0,0,0.2)',
                fontWeight: 'bold',
                margin: '-10px 0 20px 0',
                color: '#fff'
            }
        }
    },

    //Service Panel
    {
        type: 'columns',
        value: [
            '<b>☰ Menu</b>',
            '<a href="#events">Events</a>',
            '<a href="#calendar">Calendar</a>',
            '<a href="#login">LogIn</a>'
        ],
        options: {
            styles: {
                width: '200px',
                position: 'fixed',
                left: 0,
                top: '140px',
                bottom: 0,
                background: '#f5f5f5',
                borderRight: '1px solid #ddd',
                padding: '15px',
                fontSize: '0.95em',
                lineHeight: '1.8'
            }
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

    },
    // Footer
    {
        type: 'contacts',
        value: [
            {icon: 'mail', text: 'imperia_of_events@gmail.com'},
            {icon: 'phone', text: '+49 176 12345678'},
            {icon: 'language', text: 'Deutsch'}
        ],
        options: {
            styles: {
                marginLeft: '220px',
                marginTop: '40px',
                background: 'linear-gradient(135deg, rgba(66,133,244,.8) 0%, rgba(52,168,83,.8) 100%)',
                padding: '20px',
                color: '#fff',
                borderRadius: '8px',
                fontSize: '1em'
            }
        }
    },
    {
        type: 'text',
        value: '© 2025 Veranstaltung Köln | <a href="#impressum">Impressum</a> | <a href="#datenschutz">Datenschutz</a>',
        options: {
            tag: 'div',
            styles: {
                marginLeft: '220px',
                textAlign: 'center',
                fontSize: '0.85em',
                marginTop: '10px',
                marginBottom: '30px'
            }
        }
    }
]