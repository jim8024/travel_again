import { useEffect } from 'react';
const { kakao } = window;

function DetailMap({selectedItems, areaData, day}) {
    useEffect(() => {
        const { kakao } = window;
        const container = document.getElementById('map');
    
        const options = {
          center: new kakao.maps.LatLng(areaData.mapy, areaData.mapx),
          level: areaData.mlevel,
        };
        const map = new kakao.maps.Map(container, options);
    
        // Marker와 Polyline을 담을 배열
        const markers = [];
        const lines = [];
    
    
        // Map 컴포넌트 내에서 flattenedItems 로컬 변수로 설정
        const flattenedItems = selectedItems[day].flat();
    
        // 지도 중심 좌표를 설정하는 함수
        const setMapCenter = () => {
          if (flattenedItems.length > 0) {
            const bounds = new kakao.maps.LatLngBounds();
            flattenedItems.forEach((item) => {
              bounds.extend(new kakao.maps.LatLng(item.mapy, item.mapx));
            });
            map.setBounds(bounds);
          }
        };
    
        setMapCenter(); // 초기 지도 중심 좌표 설정
    
        flattenedItems.forEach((item, index) => {
          // Marker 생성
          const marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(item.mapy, item.mapx),
            title: item.title,
            image: new kakao.maps.MarkerImage(
              'http://t1.daumcdn.net/localimg/localimages/07/2018/pc/img/marker_spot.png',
              new kakao.maps.Size(24, 35)
            ),
          });
    
          markers.push(marker);
        });
    
        // Polyline 그리기
        for (let i = 1; i < markers.length; i++) {
          const linePath = [markers[i - 1].getPosition(), markers[i].getPosition()];
    
          const drawLine = new kakao.maps.Polyline({
            map: map,
            path: linePath,
            strokeWeight: 3,
            strokeColor: '#db4040',
            strokeOpacity: 1,
            strokeStyle: 'solid',
          });
    
          lines.push(drawLine);
        }
    },[selectedItems, areaData.mapx, areaData.mapy, areaData.mlevel, day]);
      return (
        <div
          id="map"
          style={{
            width: '100%',
            height: '300px',
          }}
        ></div>
      );
    }

export default DetailMap;