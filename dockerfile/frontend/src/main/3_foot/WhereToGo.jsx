import './whereToGo.css';
import * as React from 'react';
import FormControl from '@mui/material/FormControl';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import SearchIcon from '@mui/icons-material/Search';
import IconButton from '@mui/material/IconButton';
import NativeSelect from '@mui/material/NativeSelect';
import axios from 'axios';

function WhereToGo() {

    const handleSubmit = async (event) => {
        event.preventDefault();
        // ------------ 나중에 서버랑 연결할 때 주석제거하기 ---------------------------
        const data = new FormData(event.currentTarget);
        const category = data.get('category')
        const keyword = data.get('keyword')
        const url = 'http://localhost:9000/tourlist/es/overview?searchValue=' + keyword 

        try {
            const response = await axios.post(url, {
                
                
            }); 
            console.log('서버 응답:', response.data);
        } catch (error) {
            console.error('오류:', error);
        }
    };
    return (
        <div className="container">
            <h2>어디로 여행을 떠나시나요?</h2>
            <div style={{ margin: 20, padding: 20 }}>
                <Box
                    component="form"
                    onSubmit={handleSubmit}
                    sx={{
                        '& .MuiTextField-root': { m: 1, width: '80ch' },
                    }}
                    noValidate
                    autoComplete="off"
                >
                    {' '}
                    <FormControl sx={{ m: 1, minWidth: 120 }}>
                        <NativeSelect
                            defaultValue={'none'}
                            inputProps={{
                                name: 'category',
                                id: 'uncontrolled-native',
                            }}
                        >
                            <option value={'title'}>여행지</option>
                            <option value={'seoul'}>서울</option>
                            <option value={'busan'}>부산</option>
                            <option value={'daejeon'}>대전</option>
                        </NativeSelect>
                    </FormControl>
                    <TextField name="keyword" id="standard-search" type="search" variant="standard" />
                    <IconButton type="submit" sx={{ p: '10px' }} aria-label="search">
                        <SearchIcon />
                    </IconButton>
                </Box>
            </div>
        </div>
    );
}

export default WhereToGo;
