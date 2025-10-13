// import image from './assets/main_event.png'
export const model = [
    {
        type: 'title', value: 'Welcome to your event!', options:
            {
                tag: 'h2',
                styles: {
                    background: 'linear-gradient(135deg, #4285f4 0%, #34a853 100%)',
                    padding: '20px',
                    color: '#fff',
                    textShadow: '1px 1px 2px rgba(0,0,0,0.3)',
                    'text-align': 'center',
                    borderRadius: '8px',
                    boxShadow: '0 2px 4px rgba(0,0,0,0.2)',
                    fontWeight: 'bold',
                    opacity: 1
                }
            }
    },

    {type: 'text', value: 'Event1. Description for Event 1 ', options:
            {
                tag: 'h4',
                styles: {
                    background: 'linear-gradient(135deg, rgba(66, 133, 244, 0.8) 0%, rgba(52, 168, 83, 0.8) 100%)',
                    padding: '20px',
                    'text-align': 'left',
                    'font-size': '1.5em',
                    'border-radius': '8px',
                    'color': '#fff',
                    'box-shadow': '0 2px 4px rgba(0,0,0,0.2)',
                    'margin-top': '20px',
                    'margin-bottom': '20px'
                }
            }},
    {
        type: 'columns', value: [
            'column1',
            'column2',
            'column3'
        ], options: {
            styles: {
                background: 'linear-gradient(135deg, rgba(66, 133, 244, 0.8) 0%, rgba(52, 168, 83, 0.8) 100%)',
                padding: '20px',
                'text-align': 'left',
                'font-size': '1.5em',
                'border-radius': '8px',
                'color': '#fff',
                'box-shadow': '0 2px 4px rgba(0,0,0,0.2)',
                'margin-top': '20px',
                'margin-bottom': '20px'
            }
        }

    },
    {type: 'image', value: 'assets/main_event.png'}
]