import React, { useState } from 'react'
import { Menu, Container } from 'semantic-ui-react'
import SignedIn from './SignedIn'
import SignedOut from './SignedOut'

export default function Navi() {

    const [isLoggedIn, setIsLoggedIn] = useState(true)

    const handleSignOut = () => {
        setIsLoggedIn(false)
    }

    const handleSignIn = () => {
        setIsLoggedIn(true)
    }

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
                        {
                            isLoggedIn ? <SignedIn handleSignOut={handleSignOut}/> : <SignedOut handleSignIn={handleSignIn}/>
                        }                    
                    </Menu.Menu>
                </Container>
            </Menu>
        </div>
    )
}
