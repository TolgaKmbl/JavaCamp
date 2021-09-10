import React from 'react'
import { Button, Menu, Container } from 'semantic-ui-react'

export default function Navi() {
    return (
        <div>
            <Menu inverted fixed="top">
                <Container>
                    <Menu.Item
                        name='home'
                    />
                    <Menu.Item
                        name='private messages'
                    />
                    <Menu.Menu position='right'>
                        <Menu.Item>
                            <Button.Group>
                                <Button>Sign In</Button>
                                <Button.Or text='&amp;'/>
                                <Button positive>Log In</Button>
                            </Button.Group>
                        </Menu.Item>
                    </Menu.Menu>
                </Container>
            </Menu>
        </div>
    )
}
