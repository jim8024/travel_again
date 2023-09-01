import Main from "./main/head/Main"
import HowTo from "./main/body/HowTo"
import Carousel from "./main/body/Carousel";
import WhereToGo from "./main/Foot/WhereToGo";
import TourListPage from "./main/Foot/tour/TourListPage";
import CreatePlanner from "./plan/CreatePlanner"
function App() {
    return(
        <>
        {/* //     <Main /> 
        //     <HowTo/>
        //     <Carousel/>
        //     <WhereToGo/>
        //     <TourListPage/>   */}
        <CreatePlanner></CreatePlanner>
        </>
    )
}

export default App;
